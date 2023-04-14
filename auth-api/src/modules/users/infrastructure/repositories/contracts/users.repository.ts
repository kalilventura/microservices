import { SequelizeUser } from '../models/user.model';

export interface IUsersRepository {
  findByEmail(email: string): Promise<SequelizeUser | null>;
}

export const IUsersRepository = Symbol('IUsersRepository');
