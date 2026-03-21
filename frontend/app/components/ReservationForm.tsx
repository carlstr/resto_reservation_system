"use client";

import { parseDate } from "@internationalized/date";
import {
  Form,
  DateInput,
  NumberInput,
  Button,
  Select,
  SelectItem,
  TimeInput,
} from "@heroui/react";
import { FormEvent } from "react";
import { Booking } from "../types/booking";
import { DiningTable } from "../types/diningTable";
import { getDiningTable, postBooking } from "../api/api";

export default function ReservationForm() {
  const rooms = [
    { key: "terrace", label: "Terrace" },
    { key: "Inside Hall", label: "Inside Hall" },
  ];

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const formData = new FormData(e.currentTarget);

    const date = formData.get("date");
    const startTime = formData.get("startTime");
    const endTime = formData.get("endTime");
    const capacity = formData.get("capacity");
    const diningTable = formData.get("diningTable");
    const location = formData.get("location");

    const diningTabletest: DiningTable = await getDiningTable(
      diningTable.toString(),
    );

    const booking: Booking = {
      date: date ? new Date(date.toString().slice(0, 10)) : new Date(),
      startTime: startTime.toString(),
      endTime: endTime.toString(),
      capacity: parseInt(capacity.toString()),
      diningTable: diningTabletest,
      location: location.toString(),
    };

    try {
      const result = await postBooking(booking);
      console.log("Booking created: ", result);
    } catch (error) {
      console.log(error);
    }
  };

  const currDate = parseDate(new Date().toISOString().slice(0, 10));

  return (
    <Form
      className="w-full max-w-xs flex flex-col gap-4"
      onSubmit={handleSubmit}
    >
      <DateInput
        name="date"
        isRequired
        defaultValue={currDate}
        label={"Date"}
        labelPlacement="outside-top"
      />
      <TimeInput
        name="startTime"
        isRequired
        label={"Start Time"}
        labelPlacement="outside-top"
      />
      <TimeInput
        name="endTime"
        isRequired
        label={"End Time"}
        labelPlacement="outside-top"
      />
      <NumberInput
        name="capacity"
        isRequired
        className="max-w-xs"
        defaultValue={0}
        label="People Count"
        labelPlacement="outside-top"
        placeholder="0"
      />
      <Select
        name="location"
        isRequired
        items={rooms}
        label="Location"
        labelPlacement="outside-top"
      >
        {(room) => <SelectItem>{room.label}</SelectItem>}
      </Select>
      <Select
        name="diningTable"
        isRequired
        items={[
          { key: 35, label: "35" },
          { key: 36, label: "36" },
        ]}
        label="Dining Table"
        labelPlacement="outside-top"
      >
        {(item) => <SelectItem>{item.label}</SelectItem>}
      </Select>
      <Button type="submit">Submit</Button>
    </Form>
  );
}
