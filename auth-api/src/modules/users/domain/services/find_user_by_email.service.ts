import { User } from '../entities/user';

export interface IFindUserByEmailService {
  findByEmail(email: string): Promise<User>;
}

export const IFindUserByEmailService = Symbol('IFindUserByEmailService');
