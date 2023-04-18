import { User } from 'src/modules/users/domain/entities/user';
import { SequelizeUser } from '../../repositories/models/user.model';

export class UserMapper {
  public static mapToEntity(entity: SequelizeUser): User {
    return new User(null, entity.name, entity.email, null);
  }

  public static mapToSequelize(user: User): SequelizeUser {
    const model = new SequelizeUser();
    model.name = user.name;
    model.email = user.email;
    model.password = user.password;
    return model;
  }
}
