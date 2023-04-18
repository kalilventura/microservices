import { Controller, Post, Res, HttpStatus, Body } from '@nestjs/common';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import {
  GetAccessTokenCommand,
  Listeners,
} from '../../domain/commands/get_access_token.command';
import { AccessTokenRequest } from './request/access_token.request';
import { AccessTokenRequestMapper } from './request/mappers/access_token_request.mapper';
import { Token } from '../../domain/entities/token';
import { Response } from 'express';

@ApiTags('auth')
@Controller('/v1')
export class GetAccessTokenController {
  constructor(private readonly command: GetAccessTokenCommand) {}

  @Post('/token')
  public async post(
    @Body() tokenRequest: AccessTokenRequest,
    @Res() response: Response,
  ) {
    const listeners: Listeners = {
      onSuccess: (token: Token) => this.onSuccess(token, response),
      onUserNotFound: (email: string) => this.onUSerNotFound(email, response),
    };

    const entity = AccessTokenRequestMapper.mapToEntity(tokenRequest);
    await this.command.execute(entity, listeners);
  }

  private onSuccess(token: Token, response: Response): void {
    response.status(HttpStatus.OK).json(token).send();
  }

  private onUSerNotFound(email: string, response: Response): void {
    response.status(HttpStatus.NOT_FOUND).json(email).send();
  }
}
