import { User } from 'src/modules/users/domain/entities/user';
import { UserResponse } from './../user.response';
export class UserResponseMapper {
  public static mapToResponse(entity: User): UserResponse {
    return new UserResponse(entity.name, entity.email);
  }
}
