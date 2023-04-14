import { Inject, Injectable } from '@nestjs/common';
import { IFindUserByEmailService } from '../services/find_user_by_email.service';
import { User } from '../entities/user';

export interface Listeners {
  onSuccess: (user: User) => void;
  onEmpty: () => void;
}

@Injectable()
export class FindUserByEmailCommand {
  constructor(
    @Inject(IFindUserByEmailService)
    private readonly service: IFindUserByEmailService,
  ) {}

  public async execute(email: string, listeners: Listeners): Promise<void> {
    const user = await this.service.findByEmail(email);
    if (user) {
      listeners.onSuccess(user);
    } else {
      listeners.onEmpty();
    }
  }
}
