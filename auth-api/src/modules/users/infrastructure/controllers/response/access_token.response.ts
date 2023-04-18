export class AccessTokenResponse {
  constructor(token: string) {
    this.token = token;
  }
  public readonly token: string;
}
