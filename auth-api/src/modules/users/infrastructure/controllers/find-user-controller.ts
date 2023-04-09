import {Request, Response, NextFunction} from "express";
import {Listeners} from "../../domain/commands/listeners/user-listener";
import {FindUserByEmailCommand} from "../../domain/commands/find-user-by-email-command";
import {User} from "../../domain/entities/user";

class UserController {
    constructor (private findUserByEmailCommand: FindUserByEmailCommand) {}

    public async get(req: Request, resp: Response): Promise<Response | void> {
        const email: string = req.body["email"];

        const listeners: Listeners = {
            onSuccess: (user: User) => this.onSuccess(user, resp),
            onEmpty: () => this.onEmpty(resp)
        };
        this.findUserByEmailCommand.execute(email, listeners);
        return resp;
    }

    private onSuccess(user: User, resp: Response) {
        resp.json(user).status(200);
    }

    private onEmpty(resp: Response) {
        resp.status(201);
    }
};

export {UserController};
