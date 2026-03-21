const API_URL = process.env.APIURL;
import { NumberInput } from "@heroui/number-input";

export default function Home() {
  var bookingId: number;

  fetch(`${API_URL}/bookings/156`)
    .then((res) => res.json())
    .then((data) => console.log(data));

  return (
    <div>
      <p>Restoraunt Reservation System</p>
      <a href="/reservation">Make a reservation</a>
    </div>
  );
}
