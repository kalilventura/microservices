import { Module } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { FindUserByEmailCommand } from './domain/commands/find_user_by_email.command';
import { FindUserByEmailController } from './infrastructure/controllers/find_user_by_email.controller';
import { GetAccessTokenController } from './infrastructure/controllers/get_access_token.controller';
import { InsertUserController } from './infrastructure/controllers/insert_user.controller';
import { DatabaseModule } from '../global/database/database.module';
import { usersProviders } from './user.providers';
import { GetAccessTokenCommand } from './domain/commands/get_access_token.command';
import { InsertUserCommand } from './domain/commands/insert_user.command';

@Module({
  imports: [
    DatabaseModule,
    JwtModule.register({
      secret: process.env.JWT_SECRET,
      signOptions: { expiresIn: '30d' },
    }),
  ],
  controllers: [
    FindUserByEmailController,
    GetAccessTokenController,
    InsertUserController,
  ],
  providers: [
    FindUserByEmailCommand,
    GetAccessTokenCommand,
    InsertUserCommand,
    ...usersProviders,
  ],
})
export class UsersModule {}
