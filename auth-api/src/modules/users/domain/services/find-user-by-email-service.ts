import { User } from "../entities/user";

export interface IFindUserByEmailService {
    findByEmail(email: string): User | null;
}