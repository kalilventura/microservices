import {User} from "../../models/user";

export interface IUserRepository {
    findByEmail(email: string): Promise<User | null>;
}