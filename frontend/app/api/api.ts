import { Booking } from "../types/booking";
import { DiningTable } from "../types/diningTable";

const API_URL = process.env.NEXT_PUBLIC_API_URL;

export async function getDiningTable(id: string):Promise <DiningTable> {
    const response = await fetch(`${API_URL}/diningTables/${id}`);
    if (!response.ok) {
      throw new Error("Failed to fetch dining table");
    }
    return response.json();
}

export async function postBooking(booking: Booking): Promise <Booking>{
    const response = await fetch(`${API_URL}/bookings/reserve`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        ...booking,
      }),
    });

    if (!response.ok) {
      throw new Error("Failed to create booking");
    }

    return response.json();
}