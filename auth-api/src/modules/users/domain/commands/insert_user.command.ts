import { Inject, Injectable } from '@nestjs/common';
import { IFindUserByEmailService } from '../services/find_user_by_email.service';
import { IInsertUserService } from '../services/insert_user.service';
import { User } from '../entities/user';

export interface Listeners {
  onSuccess: (user: User) => void;
  onExists: (email: string) => void;
}

@Injectable()
export class InsertUserCommand {
  constructor(
    @Inject(IFindUserByEmailService)
    private readonly findUserByEmailService: IFindUserByEmailService,
    @Inject(IInsertUserService)
    private readonly insertUserService: IInsertUserService,
  ) {}

  public async execute(user: User, listeners: Listeners): Promise<void> {
    const userExists = await this.findUserByEmailService.findByEmail(
      user.email,
    );

    if (userExists) {
      listeners.onExists(user.email);
    } else {
      const newUser = await this.insertUserService.insert(user);
      listeners.onSuccess(newUser);
    }
  }
}
