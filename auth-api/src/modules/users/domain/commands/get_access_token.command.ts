import { JwtService } from '@nestjs/jwt';
import { AccessToken } from '../entities/access_token';
import { IFindUserByEmailService } from '../services/find_user_by_email.service';
import { Token } from '../entities/token';
import { Inject, Injectable } from '@nestjs/common';
import { compareSync } from 'bcrypt';

export interface Listeners {
  onSuccess: (token: Token) => void;
  onUserNotFound: (email: string) => void;
}

@Injectable()
export class GetAccessTokenCommand {
  constructor(
    private readonly jwtService: JwtService,
    @Inject(IFindUserByEmailService)
    private readonly findUserByEmailService: IFindUserByEmailService,
  ) {}

  public async execute(
    access: AccessToken,
    listeners: Listeners,
  ): Promise<void> {
    const user = await this.findUserByEmailService.findByEmail(access.email);
    if (user && compareSync(access.password, user.password)) {
      const userJwt = { username: user.email, sub: user.id };
      const token = await this.jwtService.signAsync(userJwt);
      listeners.onSuccess(new Token(token));
    } else {
      listeners.onUserNotFound(access.email);
    }
  }
}
