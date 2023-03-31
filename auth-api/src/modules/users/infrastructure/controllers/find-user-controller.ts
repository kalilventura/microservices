import {Request, Response, NextFunction} from "express";
import { FindUserByEMailCommand, Listeners } from "../../domain/commands/find-user-by-email-command";
import { User } from "../../domain/entities/user";

export class UserController {
    constructor (private command: FindUserByEMailCommand) {}

    public async get(req: Request, resp: Response, next: NextFunction): Promise<Response | void> {
        const email: string = req.body["email"];

        const listeners: Listeners = {
            onSuccess: (user: User) => this.onSuccess(user, resp),
            onEmpty: () => this.onEmpty(resp)
        };
        this.command.execute(email, listeners);
        return resp;
    }

    private onSuccess(user: User, resp: Response) {
        resp.json(user).status(200);
    }

    private onEmpty(resp: Response) {
        resp.status(201);
    }
}