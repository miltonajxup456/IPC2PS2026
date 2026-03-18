import {EventTypeEnum} from "./event-type-enum";

export interface EventToUpdateRequest {
    name: string,
    eventType: EventTypeEnum,
    limit: number,
    startDate: Date,
    price: number,

}