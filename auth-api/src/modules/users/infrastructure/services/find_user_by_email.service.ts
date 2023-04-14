import { Inject, Injectable } from '@nestjs/common';
import { User } from '../../domain/entities/user';
import { IFindUserByEmailService } from '../../domain/services/find_user_by_email.service';
import { IUsersRepository } from '../repositories/contracts/users.repository';
import { UserMapper } from './mappers/user.mapper';

@Injectable()
export class FindUserByEmailService implements IFindUserByEmailService {
  constructor(
    @Inject(IUsersRepository) private readonly repository: IUsersRepository,
  ) {}

  public async findByEmail(email: string): Promise<User> {
    const user = await this.repository.findByEmail(email);
    const mapped = user ? UserMapper.mapToEntity(user) : null;
    return Promise.resolve(mapped);
  }
}
