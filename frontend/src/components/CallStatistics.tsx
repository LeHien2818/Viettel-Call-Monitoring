import { Paper, Text, Group, ThemeIcon, Progress } from "@mantine/core"
import {

  IconPhone,
  IconPhoneCall,
  IconClock,
  IconPercentage,
} from "@tabler/icons-react"

interface CallStatisticsProps {
  title: string
  value: string
  type: "total" | "active" | "wait" | "service"
}

export function CallStatistics({ title, value, type }: CallStatisticsProps) {

  const getIcon = () => {
    switch (type) {
      case "total":
        return <IconPhone size={24} />
      case "active":
        return <IconPhoneCall size={24} />
      case "wait":
        return <IconClock size={24} />
      case "service":
        return <IconPercentage size={24} />
    }
  }

  return (
    <Paper withBorder p="md" radius="md" h="100%">
      <Group justify="space-between" mb="xs">
        <Group gap="xs">
          <ThemeIcon variant="light" size="lg" color="blue">
            {getIcon()}
          </ThemeIcon>
          <Text size="sm">{title}</Text>
        </Group>
      </Group>
      <Text size="xl" fw={700}>
        {value}
      </Text>
      {type === "service" && <Progress value={Number.parseInt(value)} mt="md" size="sm" color="blue" />}
    </Paper>
  )
}
