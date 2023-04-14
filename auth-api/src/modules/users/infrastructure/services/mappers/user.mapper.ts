import { User } from 'src/modules/users/domain/entities/user';
import { SequelizeUser } from '../../repositories/models/user.model';

export class UserMapper {
  public static mapToEntity(entity: SequelizeUser): User {
    return new User(entity.name, entity.email);
  }
}
