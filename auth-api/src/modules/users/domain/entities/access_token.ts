export class AccessToken {
  constructor(email: string, password: string) {
    this.email = email;
    this.password = password;
  }

  public readonly email: string;
  public readonly password: string;
}
