import { SequelizeUser } from '../models/user.model';

export interface IUsersRepository {
  findByEmail(email: string): Promise<SequelizeUser | null>;
  insert(user: SequelizeUser): Promise<SequelizeUser>;
}

export const IUsersRepository = Symbol('IUsersRepository');
