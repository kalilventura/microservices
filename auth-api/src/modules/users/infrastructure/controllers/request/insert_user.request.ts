import { ApiProperty } from '@nestjs/swagger';

export class InsertUserRequest {
  constructor(name: string, email: string, password: string) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  @ApiProperty({
    type: String,
    description: 'The user name',
    default: 'John Doe',
  })
  public name: string;

  @ApiProperty({
    type: String,
    description: 'The user email',
    default: 'jhon.doe@email.com',
  })
  public email: string;

  @ApiProperty({
    type: String,
    description: 'The user password',
    default: 'jhon.doe1234@at',
  })
  public password: string;
}
