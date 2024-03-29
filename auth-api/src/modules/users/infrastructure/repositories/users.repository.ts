import { Inject, Injectable } from '@nestjs/common';
import { IUsersRepository } from './contracts/users.repository';
import { SequelizeUser } from './models/user.model';

@Injectable()
export class UsersRepository implements IUsersRepository {
  constructor(
    @Inject('USERS_REPOSITORY') private userModel: typeof SequelizeUser,
  ) {}

  public async insert(user: SequelizeUser): Promise<SequelizeUser> {
    return await this.userModel.create<SequelizeUser>({
      name: user.name,
      email: user.email,
      password: user.password,
    });
  }

  public async findByEmail(email: string): Promise<SequelizeUser | null> {
    return this.userModel.findOne<SequelizeUser>({ where: { email } });
  }
}
