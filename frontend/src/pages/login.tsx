import { useEffect, useState, type FormEvent } from "react"
import { useNavigate } from "react-router-dom"
import { TextInput, PasswordInput, Checkbox, Button, Paper, Title, Text, Container, Group } from "@mantine/core"
import { notifications } from "@mantine/notifications"
import { IconEye, IconEyeOff } from "@tabler/icons-react"

export function LoginPage() {
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [rememberMe, setRememberMe] = useState(false)
  const [isLoading, setIsLoading] = useState(false)
  const navigate = useNavigate()

  // Check if user is already logged in
  useEffect(()=>{
    if (localStorage.getItem("isLoggedIn") === "true") {
      navigate("/dashboard")
      
    }
  }, [navigate])

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault()

    if (!username || !password) {
      notifications.show({
        title: "Login error",
        message: "Please enter both username and password",
        color: "red",
      })
      return
    }

    setIsLoading(true)

    try {
      // Mô phỏng API call đăng nhập
      await new Promise((resolve) => setTimeout(resolve, 1500))

      // Kiểm tra thông tin đăng nhập mẫu
      if (username === "admin" && password === "password") {
        // Lưu thông tin đăng nhập vào localStorage
        localStorage.setItem("isLoggedIn", "true")
        localStorage.setItem(
          "user",
          JSON.stringify({
            username,
            role: "supervisor",
            name: "Administrator",
          }),
        )

        notifications.show({
          title: "Login successful",
          message: "Welcome to the Call Monitoring System",
          color: "green",
        })

        // Chuyển hướng đến trang dashboard
        navigate("/dashboard")
      } else {
        notifications.show({
          title: "Login failed",
          message: "Username or password is incorrect",
          color: "red",
        })
      }
    } catch (error) {
      notifications.show({
        title: "System error",
        message: `Error when logging in. Please retry later: ${error}`,
        color: "red",
      })
    } finally {
      setIsLoading(false)
    }
  }

  return (
    <Container size={420} my={40}>
      <Title ta="center" fw={900}>
        Call Monitoring System
      </Title>
      <Text c="dimmed" size="sm" ta="center" mt={5}>
        Login to access monitoring system
      </Text>

      <Paper withBorder shadow="md" p={30} mt={30} radius="md">
        <form onSubmit={handleSubmit}>
          
          <TextInput
            styles={{
              label: { 
                fontSize: 16,
                fontWeight: 900,
              },
            }}
            label="Username"
            placeholder="Enter your username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            disabled={isLoading}
            required
          />
          <PasswordInput
            styles={{
                label: { 
                  fontSize: 16,
                  fontWeight: 900,
                },
            }}
            label="Password"
            placeholder="Enter your password"
            mt="md"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            disabled={isLoading}
            required
            visibilityToggleIcon={({ reveal }) => (reveal ? <IconEyeOff size={16} /> : <IconEye size={16} />)}
          />
          <Group justify="space-between" mt="lg">
            <Checkbox
              label="Remember me"
              checked={rememberMe}
              onChange={(e) => setRememberMe(e.currentTarget.checked)}
              disabled={isLoading}
            />
          </Group>
          <Button fullWidth mt="xl" type="submit" loading={isLoading}>
            Login
          </Button>
          <Text c="dimmed" size="xs" ta="center" mt="sm">
            Login sample account: admin / password
          </Text>
        </form>
      </Paper>
    </Container>
  )
}
