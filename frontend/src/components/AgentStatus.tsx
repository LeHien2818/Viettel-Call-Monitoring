import { Badge, Text, Group, Stack, Box, Divider, ScrollArea } from "@mantine/core"
interface Agent {
  id: string
  avatar?: string
  status: "online" | "offline"
}
  

export function AgentStatus({agents, filter}: { agents?: Agent[], filter?: string }) {

  agents = agents?.filter(agent => {
    if (filter == "all") return true
    if (filter == "online") return agent.status === "online"
    if (filter == "offline") return agent.status === "offline"
  })
  const getStatusBadge = (status: Agent["status"]) => {
    switch (status) {
      case "online":
        return <Badge color="green">Online</Badge>
      // case "busy":
      //   return <Badge color="yellow">Busy</Badge>
      case "offline":
        return <Badge color="gray">Offline</Badge>
    }
  }

  return (

    <ScrollArea h={800} type="scroll" offsetScrollbars>
    <Stack gap="md">
      {agents?.map((agent, index) => (
        <Box key={agent.id}>
          <Group justify="space-between" mb="xs">
            <Group>
              
              <div>
                <Text size="sm" fw={500}>
                  {agent.id[0].toUpperCase() + agent.id.slice(1)}
                </Text>
                <Text size="xs" c="dimmed">
                  Employee
                </Text>
              </div>
            </Group>
            {getStatusBadge(agent.status)}
          </Group>

         

          {index < agents.length - 1 && <Divider my="sm" />}
        </Box>
      ))}
    </Stack>
    </ScrollArea>
  )
}
