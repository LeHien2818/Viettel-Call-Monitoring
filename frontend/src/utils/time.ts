const convertUnixEpochToTime = (unixTimestamp:string) => {
  const convertedTimeStamp = parseInt(unixTimestamp)
  const milliseconds = convertedTimeStamp * 1000;
  const date = new Date(milliseconds);

  return date.toLocaleString("vn-VN", {
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false,
  });
}

export function formatElapsedTime(seconds: number): string {
  const mins = Math.floor(seconds / 60) >= 0 ? Math.floor(seconds / 60) : 0
  const secs = seconds % 60 >= 0 ? seconds % 60 : 0
  return `${String(mins).padStart(2, "0")}:${String(secs).padStart(2, "0")}`
}

export default convertUnixEpochToTime;