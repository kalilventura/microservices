import { User } from 'src/modules/users/domain/entities/user';
import { InsertUserRequest } from '../insert_user.request';

export class InsertUserRequestMapper {
  public static mapToEntity(insertRequest: InsertUserRequest): User {
    return new User(
      null,
      insertRequest.name,
      insertRequest.email,
      insertRequest.password,
    );
  }
}
