import { ApiProperty } from '@nestjs/swagger';

export class UserResponse {
  constructor(name: string, email: string) {
    this.name = name;
    this.email = email;
  }

  @ApiProperty({
    type: String,
    description: 'The user name',
    default: 'John Doe',
  })
  public readonly name: string;

  @ApiProperty({
    type: String,
    description: 'The user email',
    default: 'jhon.doe@email.com',
  })
  public readonly email: string;
}
