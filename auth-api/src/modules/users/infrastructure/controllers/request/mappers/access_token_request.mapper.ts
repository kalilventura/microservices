import { User } from '../../../../domain/entities/user';
import { AccessTokenRequest } from '../access_token.request';

export class AccessTokenRequestMapper {
  public static mapToEntity(accessToken: AccessTokenRequest): User {
    return new User(null, null, accessToken.email, accessToken.password);
  }
}
