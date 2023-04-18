import { Controller, Get, Param, Res, HttpStatus } from '@nestjs/common';
import { Response } from 'express';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import {
  FindUserByEmailCommand,
  Listeners,
} from '../../domain/commands/find_user_by_email.command';
import { UserResponse } from './response/user.response';
import { User } from '../../domain/entities/user';
import { UserResponseMapper } from './response/mappers/user.response.mapper';

@ApiTags('users')
@Controller('/v1')
export class FindUserByEmailController {
  constructor(private readonly command: FindUserByEmailCommand) {}

  @Get('/users/:email')
  @ApiOperation({ summary: 'Find an user by the target email.' })
  @ApiResponse({ status: 200, description: 'User found.', type: UserResponse })
  @ApiResponse({ status: 204, description: 'User not found.' })
  public async get(@Param('email') email: string, @Res() response: Response) {
    const listeners: Listeners = {
      onSuccess: (user: User) => this.onSuccess(user, response),
      onEmpty: () => this.onEmpty(response),
    };
    await this.command.execute(email, listeners);
  }

  private onSuccess(user: User, response: Response) {
    response
      .status(HttpStatus.OK)
      .json(UserResponseMapper.mapToResponse(user))
      .send();
  }

  private onEmpty(response: Response) {
    response.status(HttpStatus.NO_CONTENT).send();
  }
}
