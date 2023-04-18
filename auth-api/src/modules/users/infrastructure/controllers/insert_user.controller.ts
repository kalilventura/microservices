import { InsertUserRequest } from './request/insert_user.request';
import { Response } from 'express';
import { Controller, Post, Res, HttpStatus, Body } from '@nestjs/common';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import {
  InsertUserCommand,
  Listeners,
} from '../../domain/commands/insert_user.command';
import { User } from '../../domain/entities/user';
import { InsertUserRequestMapper } from './request/mappers/insert_user_request.mapper';
import { UserResponse } from './response/user.response';
import { UserResponseMapper } from './response/mappers/user.response.mapper';

@ApiTags('users')
@Controller('/v1')
export class InsertUserController {
  constructor(private readonly command: InsertUserCommand) {}

  @Post('/users')
  @ApiOperation({ summary: 'Create a new user.' })
  @ApiResponse({
    status: 201,
    description: 'User created.',
    type: UserResponse,
  })
  @ApiResponse({ status: 409, description: 'User already exists.' })
  public async post(
    @Body() userRequest: InsertUserRequest,
    @Res() response: Response,
  ): Promise<void> {
    const listeners: Listeners = {
      onSuccess: (user: User) => this.onCreated(user, response),
      onExists: (email: string) => this.onExists(email, response),
    };

    const user = InsertUserRequestMapper.mapToEntity(userRequest);
    await this.command.execute(user, listeners);
  }

  private onCreated(user: User, response: Response): void {
    response
      .status(HttpStatus.CREATED)
      .json(UserResponseMapper.mapToResponse(user))
      .send();
  }

  private onExists(email: string, response: Response): void {
    response.status(HttpStatus.CONFLICT).json(email).send();
  }
}
