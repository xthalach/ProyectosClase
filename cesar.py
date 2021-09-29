import string
import sys, getopt



# Demanar si vol l'ouput a un fitxer --output
def algorithm(job,slash,text):
	resultat=""
	if job == "--encode":
		for i in text.lower():
			for j in string.ascii_lowercase:
				if j == i:
					dec = ord(j) + slash
					resultat = resultat + chr(dec)

		f = open("decodeText","a")
		f.write(resultat)
		print(resultat)

	elif job == "--decode":
		for i in text.lower():
			for j in string.ascii_lowercase:
				if j == i:
					dec = chr(j) - slash
					resultat = resultat - ord(dec)


if __name__ == '__main__':

	f = open(sys.argv[2], "r")
	if sys.argv[1] == "--encode":
		algorithm(sys.argv[1],2, f.read())
	elif sys.argv[1] == "--decode":
		algorithm(sys.argv[1],2, f.read())
	elif sys.argv[1] == "--help":
		print("Usage: --encode to encript the ")

		print("Usage: --help to display the usage instructions")
