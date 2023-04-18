import { User } from '../entities/user';

export interface IInsertUserService {
  insert(user: User): Promise<User>;
}

export const IInsertUserService = Symbol('IInsertUserService');
