import { notifications } from "@mantine/notifications"

type CallStatus = "creating" | "queueing" | "ringing" | "answering"

interface Call {
  id: string
  phoneNumber: string
  agent: {
    id: string
    name: string
    avatar?: string
  }
  queue: string
  status: CallStatus
  duration: string
  startTime: Date
}

// Mock data for calls
const mockCalls: Call[] = [
  {
    id: "call-1",
    phoneNumber: "0912345678",
    agent: {
      id: "agent-1",
      name: "Nguyễn Văn A",
      avatar: "https://i.pravatar.cc/150?img=1",
    },
    queue: "support",
    status: "queueing",
    duration: "05:23",
    startTime: new Date(Date.now() - 323000),
  },
  {
    id: "call-2",
    phoneNumber: "0987654321",
    agent: {
      id: "agent-2",
      name: "Trần Thị B",
      avatar: "https://i.pravatar.cc/150?img=2",
    },
    queue: "sales",
    status: "ringing",
    duration: "00:12",
    startTime: new Date(Date.now() - 12000),
  },
  {
    id: "call-3",
    phoneNumber: "0977123456",
    agent: {
      id: "agent-3",
      name: "Lê Văn C",
      avatar: "https://i.pravatar.cc/150?img=3",
    },
    queue: "billing",
    status: "ringing",
    duration: "02:45",
    startTime: new Date(Date.now() - 165000),
  },
  {
    id: "call-4",
    phoneNumber: "0909123456",
    agent: {
      id: "agent-4",
      name: "Phạm Thị D",
      avatar: "https://i.pravatar.cc/150?img=4",
    },
    queue: "support",
    status: "answering",
    duration: "08:17",
    startTime: new Date(Date.now() - 497000),
  },
  {
    id: "call-5",
    phoneNumber: "0918765432",
    agent: {
      id: "agent-5",
      name: "Hoàng Văn E",
      avatar: "https://i.pravatar.cc/150?img=5",
    },
    queue: "sales",
    status: "queueing",
    duration: "03:51",
    startTime: new Date(Date.now() - 231000),
  },
]

// Fetch all call data
export async function fetchCallData() {
  try {
    // Simulate API call
    await new Promise((resolve) => setTimeout(resolve, 500))

    // In a real app, this would be an API call
    return {
      calls: mockCalls,
      stats: {
        totalCalls: 487,
        activeCalls: 245,
        avgWaitTime: "1:24",
        serviceLevel: 94,
      },
    }
  } catch (error) {
    notifications.show({
      title: "Lỗi kết nối",
      message: "Không thể kết nối đến máy chủ dữ liệu",
      color: "red",
    })
    throw error
  }
}

// Fetch calls only
export async function fetchCalls() {
  try {
    // Simulate API call
    await new Promise((resolve) => setTimeout(resolve, 500))

    // In a real app, this would be an API call
    return mockCalls
  } catch (error) {
    notifications.show({
      title: "Lỗi kết nối",
      message: "Không thể kết nối đến máy chủ dữ liệu",
      color: "red",
    })
    throw error
  }
}
