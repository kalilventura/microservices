import { User } from "../../domain/entities/user";
import { IFindUserByEmailService } from "../../domain/services/find-user-by-email-service";
import { IUserRepository } from "../repositories/contracts/user-repository";

export class FindUserByEmailService implements IFindUserByEmailService {
    constructor(private userRepository: IUserRepository) {}

    public async findByEmail(email: string): Promise<User | null> {
        return await this.userRepository.findByEmail(email);
    }
}