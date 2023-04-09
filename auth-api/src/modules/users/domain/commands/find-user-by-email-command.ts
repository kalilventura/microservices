import { IFindUserByEmailService } from "../services/find-user-by-email-service";
import { Listeners } from "./listeners/user-listener";

export class FindUserByEmailCommand {
    constructor(private getUserFindByEmailService: IFindUserByEmailService) {}

    public execute(email: string, listeners: Listeners): void {
        const user = this.getUserFindByEmailService.findByEmail(email);
        if (user) {
            listeners.onSuccess(user);
        } else {
            listeners.onEmpty();
        }
    }
}