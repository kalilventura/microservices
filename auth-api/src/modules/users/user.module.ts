import { Module } from '@nestjs/common';
import { FindUserByEmailCommand } from './domain/commands/find_user_by_email.command';
import { FindUserByEmailController } from './infrastructure/controllers/find_user_by_email.controller';
import { DatabaseModule } from '../global/database/database.module';
import { usersProviders } from './user.providers';

@Module({
  imports: [DatabaseModule],
  controllers: [FindUserByEmailController],
  providers: [FindUserByEmailCommand, ...usersProviders],
})
export class UsersModule {}
