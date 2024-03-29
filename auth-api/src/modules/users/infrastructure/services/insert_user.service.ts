import { Inject, Injectable } from '@nestjs/common';
import { User } from '../../domain/entities/user';
import { IInsertUserService } from '../../domain/services/insert_user.service';
import { IUsersRepository } from '../repositories/contracts/users.repository';
import { UserMapper } from './mappers/user.mapper';
import { hash } from 'bcrypt';

@Injectable()
export class InsertUserService implements IInsertUserService {
  constructor(
    @Inject(IUsersRepository) private readonly repository: IUsersRepository,
  ) {}

  public async insert(user: User): Promise<User> {
    const mapped = UserMapper.mapToSequelize(user);
    mapped.password = await hash(mapped.password, 10);
    const newUser = await this.repository.insert(mapped);
    return UserMapper.mapToEntity(newUser);
  }
}
