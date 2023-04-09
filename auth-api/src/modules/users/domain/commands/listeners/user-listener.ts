import {User} from "../../entities/user";

export interface Listeners {
    onSuccess: (user: User) => void;
    onEmpty: () => void;
}