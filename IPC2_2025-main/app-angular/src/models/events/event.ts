import {EventTypeEnum} from "./event-type-enum";

export interface Event {
    code: string,
    name: string,
    eventType: EventTypeEnum,
    limit: number,
    startDate: Date,
    price: number,

}