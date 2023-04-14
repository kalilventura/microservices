import { Scope, Provider } from '@nestjs/common';
import { SequelizeUser } from './infrastructure/repositories/models/user.model';
import { FindUserByEmailService } from './infrastructure/services/find_user_by_email.service';
import { IFindUserByEmailService } from './domain/services/find_user_by_email.service';
import { IUsersRepository } from './infrastructure/repositories/contracts/users.repository';
import { UsersRepository } from './infrastructure/repositories/users.repository';

export const usersProviders: Provider[] = [
  {
    provide: 'USERS_REPOSITORY',
    useValue: SequelizeUser,
    scope: Scope.TRANSIENT,
  },
  {
    provide: IFindUserByEmailService,
    useClass: FindUserByEmailService,
    scope: Scope.TRANSIENT,
  },
  {
    provide: IUsersRepository,
    useClass: UsersRepository,
    scope: Scope.TRANSIENT,
  },
];
