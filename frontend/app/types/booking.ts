import { DiningTable } from "./diningTable";

export interface Booking {
    date: Date;
    startTime: string;
    endTime: string;
    capacity: number;
    diningTable: DiningTable;
    location: string;
}