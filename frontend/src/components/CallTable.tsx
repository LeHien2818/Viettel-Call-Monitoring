import { Table, Badge, Group, Text, Loader, Center, ScrollArea, Pagination, Select, Flex } from "@mantine/core"
import { IconPhone, IconClock } from "@tabler/icons-react"
import type { CallData } from "../types/type"
import convertUnixEpochToTime from "../utils/time"
import { formatElapsedTime } from "../utils/time"
import { useEffect, useState } from "react"

type CallStatus = "creating" | "queueing" | "ringing" | "answering"

interface CallTableProps {
  filterPhone: string
  filterQueue: string
  isLoading?: boolean
  calls: CallData[]
}

export function CallTable({ filterPhone, filterQueue, calls }: CallTableProps) {
  console.log("CallTable rendered with calls:", calls);

  const [now, setNow] = useState(Date.now())
  const [currentPage, setCurrentPage] = useState(1)
  const [rowsPerPage, setRowsPerPage] = useState("10")

  useEffect(() => {
    const interval = setInterval(() => {
      setNow(Date.now())
    }, 1000)

    return () => clearInterval(interval)
  }, [])

  const getStatusBadge = (status: CallStatus) => {
    switch (status) {
      case "creating":
        return (
          <Badge color="gray" variant="light">
            Creating
          </Badge>
        )
      case "queueing":
        return (
          <Badge color="yellow" variant="light">
            Queueing
          </Badge>
        )
      case "ringing":
        return (
          <Badge color="blue" variant="light">
            Ringing
          </Badge>
        )
      case "answering":
        return (
          <Badge color="green" variant="light">
            Answering
          </Badge>
        )
    }
  }

  const filteredCalls = calls.filter((call) => {
    let filterCriteria: boolean = false
    let directionCondition = "inbound"
    let filterStateCondition = filterQueue
    if (filterQueue === "creating") {
      filterStateCondition = "CREATED"
      directionCondition = "inbound"
      if (call.state == filterStateCondition && call.direction === directionCondition) {
        filterCriteria = true
      }
    } else if (filterQueue === "queueing") {
      filterStateCondition = "QUEUED"
      if (call.state == filterStateCondition) {
        filterCriteria = true
      }
    } else if (filterQueue === "ringing") {
      filterStateCondition = "CREATED"
      directionCondition = "outbound"
      if (call.state == filterStateCondition && call.direction === directionCondition) {
        filterCriteria = true
      }
    } else if (filterQueue === "answering") {
      filterStateCondition = "ANSWERED"
      if (call.state == filterStateCondition) {
        filterCriteria = true
      }
    }

    return (
      (filterPhone === "" || call.callerIdNumber.includes(filterPhone)) &&
      (filterQueue === "all" || filterCriteria)
    )
  })

  const isLoading = false
  const parentLoading = false

  // Pagination logic
  const totalPages = Math.ceil(filteredCalls.length / Number(rowsPerPage))
  const startIndex = (currentPage - 1) * Number(rowsPerPage)
  const endIndex = startIndex + Number(rowsPerPage)
  const paginatedCalls = filteredCalls.slice(startIndex, endIndex)

  // Reset to first page if rows per page changes or filters change
  useEffect(() => {
    setCurrentPage(1)
  }, [rowsPerPage, filterPhone, filterQueue])

  if (isLoading || parentLoading) {
    return (
      <Center h={200}>
        <Loader />
      </Center>
    )
  }

  return (
    <>
      <ScrollArea h={600} type="auto" aria-colspan={7}>
        <Table striped highlightOnHover>
          <Table.Thead>
            <Table.Tr>
              <Table.Th>Caller phone number</Table.Th>
              <Table.Th>To phone number</Table.Th>
              <Table.Th>Agent ID</Table.Th>
              <Table.Th>Queue ID</Table.Th>
              <Table.Th>Status</Table.Th>
              <Table.Th>Timestamp</Table.Th>
              <Table.Th>Duration</Table.Th>
            </Table.Tr>
          </Table.Thead>
          <Table.Tbody>
            {paginatedCalls.length === 0 ? (
              <Table.Tr>
                <Table.Td colSpan={7} style={{ textAlign: "center" }}>
                  <Text c="dimmed">There is no call</Text>
                </Table.Td>
              </Table.Tr>
            ) : (
              paginatedCalls.map((call) => {
                const elapsedSeconds = Math.floor((now - Number(call.createdTime)) / 1000)

                return (
                  <Table.Tr key={call.callerIdNumber}>
                    <Table.Td>
                      <Group gap="xs">
                        <IconPhone size={16} color="gray" />
                        <Text>{call.callerIdNumber}</Text>
                      </Group>
                    </Table.Td>
                    <Table.Td>
                      <Group gap="xs">
                        <IconPhone size={16} color="gray" />
                        <Text>{"+841068"}</Text>
                      </Group>
                    </Table.Td>
                    <Table.Td>
                      <Group gap="sm">
                        <Text>{call.calleeIdNumber}</Text>
                      </Group>
                    </Table.Td>
                    <Table.Td>
                      <Group gap="sm">
                        <Text>{call.queueId ? call.queueId : "....."}</Text>
                      </Group>
                    </Table.Td>
                    <Table.Td>
                      {(call.state === "CREATED" && call.direction === "inbound") ? getStatusBadge("creating") :
                        call.state === "QUEUED" ? getStatusBadge("queueing") :
                        (call.state === "CREATED" && call.direction === "outbound") ? getStatusBadge("ringing") :
                        call.state === "ANSWERED" ? getStatusBadge("answering") : null}
                    </Table.Td>
                    <Table.Td>
                      <Group gap="xs">
                        <Text>{convertUnixEpochToTime(call.createdTime)}</Text>
                      </Group>
                    </Table.Td>
                    <Table.Td>
                      <Group gap="xs">
                        <IconClock size={16} color="gray" />
                        <Text>{formatElapsedTime(elapsedSeconds)}</Text>
                      </Group>
                    </Table.Td>
                  </Table.Tr>
                )
              })
            )}
          </Table.Tbody>
        </Table>
      </ScrollArea>
      <Flex justify="space-between" align="center" mt="md">
        <Select
          label="Rows per page"
          value={rowsPerPage}
          onChange={(value) => setRowsPerPage(value || "10")}
          data={[
            { value: "5", label: "5" },
            { value: "10", label: "10" },
            { value: "20", label: "20" },
            { value: "50", label: "50" },
          ]}
          style={{ width: "120px" }}
        />
        <Pagination
          total={totalPages}
          value={currentPage}
          onChange={setCurrentPage}
          withEdges
        />
      </Flex>
    </>
  )
}