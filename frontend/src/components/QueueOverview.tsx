// import { Badge } from "@/components/ui/badge"
import { Text, Group, Stack, Box, Divider, Badge, ScrollArea } from "@mantine/core"

interface QueueData {
  id: string
  name: string
  
}

export function QueueOverview() {
  const queues: QueueData[] = [
    {
      id: "queue-1",
      name: "Queue 1"
    },
    {
      id: "queue-2",
      name: "Queue 2"
    },
    {
      id: "queue-3",
      name: "Queue 3"
    },
    {
      id: "queue-4",
      name: "Queue 4"
    },
    {
      id: "queue-5",
      name: "Queue 5"
    },
    {
      id: "queue-5",
      name: "Queue 5"
    },
    {
      id: "queue-6",
      name: "Queue 6"
    },
    {
      id: "queue-7",
      name: "Queue 7"
    },
    {
      id: "queue-8",
      name: "Queue 8"
    },
    {
      id: "queue-9",
      name: "Queue 9"
    },
    {
      id: "queue-10",
      name: "Queue 10"
    }
  ]

  return (
    <ScrollArea h={800} type="scroll">
    <Stack gap="md">
      {queues.map((queue, index) => (
        <Box key={queue.id}>
          <Group justify="space-between" mb="xs">
            <Text fw={500}>{queue.name}</Text>
            <Badge color="green" variant="light">
              In serving
            </Badge>
          </Group>

         
          {index < queues.length - 1 && <Divider my="sm" />}
        </Box>
      ))}
    </Stack>
    </ScrollArea>
  )
}
