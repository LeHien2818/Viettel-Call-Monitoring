import { useEffect, useState } from "react"
import { CallMonitoringDashboard } from "../components/CallMonitoring"
import { useDocumentTitle } from "@mantine/hooks"
import io from "socket.io-client"
import { type CallData } from "../types/type"

const socket = io("http://localhost:8085");

console.log("DashboardPage rendered");


export function DashboardPage() {
  useDocumentTitle("Call Monitoring System")

  // const [callMessage, setCallMessage] = useState<CallData>({} as CallData)
  
  const [renderedData, setRenderedData] = useState<CallData[]>([])

   useEffect(() => {
    const handler = (data: string) => {
      const parsedData: CallData = JSON.parse(data)
      console.log("Received call message:", parsedData);
      
      const callerId = parsedData?.callerIdNumber

      setRenderedData(prevData => {
        const existingIndex = prevData.findIndex(item => item?.callerIdNumber === callerId)
        const updatedData = [...prevData] 

        if (existingIndex !== -1) {
          if (parsedData.state === "DESTROYED" ||
              parsedData.state === "UNBRIDGED" ||
              parsedData.state === "BRIDGED") {
            // Remove the item
            updatedData.splice(existingIndex, 1)
          } else {
            // Update the existing item
            updatedData.splice(existingIndex, 1)
            updatedData.push(parsedData) 
          }
        } else {
          // Add new item
          if (parsedData.state !== "DESTROYED" &&
              parsedData.state !== "UNBRIDGED" &&
              parsedData.state !== "BRIDGED") {
            // Remove the item
            updatedData.push(parsedData)
          }
        }

        return updatedData
      })
    }

    socket.on("call-message", handler)

    // Clean up on unmount
    return () => {
      socket.off("call-message", handler)
    }
  }, [socket])

  return <CallMonitoringDashboard callData={renderedData}/>
}
