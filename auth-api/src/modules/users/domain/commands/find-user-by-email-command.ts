import { User } from "../entities/user";
import { IFindUserByEmailService } from "../services/find-user-by-email-service";

export interface Listeners {
    onSuccess: (user: User) => void;
    onEmpty: () => void;
}

export class FindUserByEMailCommand {
    constructor(private service: IFindUserByEmailService) {}

    public execute(email: string, listeners: Listeners): void {
        const user = this.service.findByEmail(email);
        if (user) {
            listeners.onSuccess(user);
        } else {
            listeners.onEmpty();
        }
    }
}