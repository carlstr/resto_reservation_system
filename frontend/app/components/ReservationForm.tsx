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

export default function ReservationForm() {
  const items = [
    { key: "terrace", label: "Terrace" },
    { key: "Inside Hall", label: "Inside Hall" },
  ];

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const formData = new FormData(e.currentTarget);

    const date = formData.get("date");
    const startTime = formData.get("startTime");
    const endTime = formData.get("endTime");
    const capacity = formData.get("capacity");
    const diningTable = formData.get("diningTable");
    const location = formData.get("location");

    console.log({ date, startTime, endTime, capacity, diningTable, location });
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
        items={items}
        label="Location"
        labelPlacement="outside-top"
      >
        {(item) => <SelectItem>{item.label}</SelectItem>}
      </Select>
      <Select
        name="diningTable"
        isRequired
        items={[
          { key: 1, label: "1" },
          { key: 2, label: "2" },
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
