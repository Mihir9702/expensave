import axios from 'axios'

export const AuthService = {
	localhost: 'http://localhost:4000',

	register: async (username: string, password: string) => {
		try {
			const response = await axios.post('http://localhost:4000/register', {
				username,
				password,
			})
			return response.data
		} catch (error: any) {
			return error.response.data
		}
	},

	login: async (username: string, password: string) => {
		try {
			const response = await axios.post('http://localhost:4000/login', {
				username,
				password,
			})
			return response.data
		} catch (error: any) {
			return error.response.data
		}
	},
}
