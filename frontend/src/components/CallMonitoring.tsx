"use client"

import { useState, useEffect } from "react"
import { useNavigate } from "react-router-dom"
import {
  AppShell,
  Burger,
  Group,
  Title,
  Text,
  Button,
  Grid,
  Paper,
  Tabs,
  TextInput,
  Select,
  Badge,
  Container,
  Box,
  ActionIcon,
  Flex
} from "@mantine/core"
import { notifications } from "@mantine/notifications"
import { IconSearch, IconRefresh, IconLogout, IconUsers, IconList } from "@tabler/icons-react"
import { CallTable } from "./CallTable"
import { CallStatistics } from "./CallStatistics"
import { AgentStatus } from "./AgentStatus"
import { QueueOverview } from "./QueueOverview"
import { type CallData } from "../types/type"

interface Agent {
  id: string
  avatar?: string
  status: "online" | "offline"
}

export function CallMonitoringDashboard({callData}: { callData: CallData[] }) {

  // console.log(callData);
    const initialAgents: Agent[] = [
      { id: "agent-1", status: "online" },
      { id: "agent-2", status: "online" },
      { id: "agent-3", status: "online" },
      { id: "agent-4", status: "online" },
      { id: "agent-5", status: "online" },
      { id: "agent-6", status: "online" },
      { id: "agent-7", status: "online" },
      { id: "agent-8", status: "online" },
      { id: "agent-9", status: "online" },
      { id: "agent-10", status: "online" },
      { id: "agent-11", status: "offline" }
  ]

  // handle agents status




  const [opened, setOpened] = useState(false)
  const [filterPhone, setFilterPhone] = useState("")
  const [filterQueue, setFilterQueue] = useState<string | null>("all")
  const [filterAgent, setFilterAgent] = useState<string | null>("all")
  const [user, setUser] = useState<{ name: string; role: string } | null>(null)
  const [agents] = useState<Agent[]>(initialAgents)
  const navigate = useNavigate()

  const isConnected = true

  useEffect(() => {
    // Lấy thông tin người dùng từ localStorage
    const userStr = localStorage.getItem("user")
    if (userStr) {
      try {
        const userData = JSON.parse(userStr)
        setUser(userData)
      } catch (e) {
        console.error("Error in analyzing user data:", e)
      }
    }
  }, [])

  const handleRefresh = () => {
    window.location.reload()
    notifications.show({
      title: "Data refreshed",
      message: "Call data has been refreshed successfully",
      color: "blue",
    })
  }

  const handleLogout = () => {
    localStorage.removeItem("isLoggedIn")
    localStorage.removeItem("user")
    notifications.show({
      title: "Logout successful",
      message: "You have been logged out successfully",
      color: "blue",
    })
    navigate("/")
  }

  return (
    <AppShell
      header={{ height: 60 }}
      navbar={{ width: 0, breakpoint: "sm", collapsed: { desktop: true, mobile: !opened } }}
      padding="md"
    >
      <AppShell.Header>
        <Group h="100%" px="md" justify="space-between">
          <Group>
            <Burger opened={opened} onClick={() => setOpened((o) => !o)} hiddenFrom="sm" size="sm" />
            <Title order={3}>Call Monitoring System</Title>
          </Group>
          <Group>
            {user && (
              <Text size="sm" c="dimmed" visibleFrom="sm">
                Hi,{" "}
                <Text span fw={500}>
                  {user.name}
                </Text>
              </Text>
            )}
            <Badge color={isConnected ? "green" : "red"} variant="light">
              {isConnected ? "Connected" : "Disconnected"}
            </Badge>
            <ActionIcon variant="light" color="blue" onClick={handleRefresh}>
              <IconRefresh size={18} />
            </ActionIcon>
            <Button variant="light" leftSection={<IconLogout size={16} />} onClick={handleLogout}>
              Logout
            </Button>
          </Group>
        </Group>
      </AppShell.Header>

      <AppShell.Main>
        <Container size="xl">
          <Box mb="md">
            <Text c="dimmed">Monitoring activities of {isConnected ? "incoming" : "0"} active calls</Text>
          </Box>

          <Grid mb="md">
            <Grid.Col span={{ base: 12, md: 3 }}>
              <CallStatistics title="Total calls" value={callData.length.toString()} type="total" />
            </Grid.Col>
            <Grid.Col span={{ base: 12, md: 3 }}>
              <CallStatistics title="Processing" value="245" type="active" />
            </Grid.Col>
            <Grid.Col span={{ base: 12, md: 3 }}>
              <CallStatistics title="Average waiting" value="1:24" type="wait" />
            </Grid.Col>
            <Grid.Col span={{ base: 12, md: 3 }}>
              <CallStatistics title="Serving percentage" value="94%" type="service" />
            </Grid.Col>
          </Grid>

          <Grid>
            <Grid.Col span={{ base: 12, lg: 8 }}>
              <Paper shadow="xs" p="md" radius="md" withBorder>
                <Flex justify="space-between" align="center" mb="md" wrap="wrap" gap="sm">
                  <Box>
                    <Title order={4}>In process active calls</Title>
                    <Text size="sm" c="dimmed">
                      Last access: {new Date().toLocaleTimeString()}
                    </Text>
                  </Box>
                  <Group>
                    <TextInput
                      placeholder="Find phone number..."
                      leftSection={<IconSearch size={16} />}
                      value={filterPhone}
                      onChange={(e) => setFilterPhone(e.currentTarget.value)}
                      style={{ width: "210px" }}
                    />
                    <Select
                      placeholder="Select state"
                      data={[
                        { value: "all", label: "All state" },
                        { value: "creating", label: "Creating" },
                        { value: "queueing", label: "Queueing" },
                        { value: "ringing", label: "Ringing" },
                        { value: "answering", label: "Answering" },
                      ]}
                      value={filterQueue}
                      onChange={setFilterQueue}
                      style={{ width: "180px" }}
                    />
                  </Group>
                </Flex>
                <CallTable
                  filterPhone={filterPhone}
                  filterQueue={filterQueue || ""}
                  isLoading={false}
                  calls={callData}
                />
              </Paper>
            </Grid.Col>

            <Grid.Col span={{ base: 12, lg: 4 }}>
              <Paper shadow="xs" p="md" radius="md" withBorder h="100%">
                <Title order={4} mb="xs">
                  System Overview
                </Title>
                <Text size="sm" c="dimmed" mb="md">
                  Overview status of agents and queues
                </Text>

                <Tabs defaultValue="agents">
                  <Tabs.List>
                    <Tabs.Tab value="agents" leftSection={<IconUsers size={16} />}>
                      Agent
                    </Tabs.Tab>
                    <Tabs.Tab value="queues" leftSection={<IconList size={16} />}>
                      Queue
                    </Tabs.Tab>
                  </Tabs.List>

                  <Tabs.Panel value="agents" pt="md">
                    <Flex justify="space-between" align="center" mb="md">
                      <Text fw={500} size="sm">
                        Agent status
                      </Text>
                      <Select
                        placeholder="Agents filter"
                        data={[
                          { value: "all", label: "All" },
                          { value: "online", label: "Online" },
                          { value: "offline", label: "Offline" },
                        ]}
                        value={filterAgent}
                        onChange={setFilterAgent}
                        style={{ width: "140px" }}
                      />
                    </Flex>
                    <AgentStatus agents={agents} filter={filterAgent ?? undefined}/>
                  </Tabs.Panel>

                  <Tabs.Panel value="queues" pt="md">
                    <QueueOverview />
                  </Tabs.Panel>
                </Tabs>
              </Paper>
            </Grid.Col>
          </Grid>
        </Container>
      </AppShell.Main>
    </AppShell>
  )
}
