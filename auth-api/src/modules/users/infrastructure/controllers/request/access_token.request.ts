import { ApiProperty } from '@nestjs/swagger';

export class AccessTokenRequest {
  constructor(email: string, password: string) {
    this.email = email;
    this.password = password;
  }

  @ApiProperty({
    type: String,
    description: 'The user email',
    default: 'jhon.doe@email.com',
  })
  public readonly email: string;

  @ApiProperty({
    type: String,
    description: 'The user password',
    default: 'jhon.doe1234@at',
  })
  public readonly password: string;
}
