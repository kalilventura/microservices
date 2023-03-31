
import { User } from "../models/user";
import { IUserRepository } from "./contracts/user-repository";

export class UserRepository implements IUserRepository {

    public async findByEmail(email: string): Promise<User | null> {
        return User.findOne({ where: { email } });
    }

}