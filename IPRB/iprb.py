
def mendal(k, m, n):

    total = k + m + n
    
    AaAa = 0.25 * (m / total) * ((m-1 )/ (total-1))
    Aaaa = 0.5 * 2 * (m / total) * (n / (total-1))
    aaaa = 1 * (n / total) * ((n-1) / (total-1))

    return 1 - (AaAa + Aaaa + aaaa)


if  __name__ == "__main__":

    with open("rosalind_iprb.txt", "r") as f:
        k, m, n = [int(x) for x in next(f).split(" ")]

    with open("output.txt", "w+") as o:
        o.write(str(mendal(k, m, n)))
