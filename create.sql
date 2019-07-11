--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1 (Debian 11.1-2)
-- Dumped by pg_dump version 11.1 (Debian 11.1-2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: signup; Type: TABLE; Schema: public; Owner: kuro
--

CREATE TABLE public.signup (
    id integer NOT NULL,
    name character varying,
    email character varying,
    password character varying
);


ALTER TABLE public.signup OWNER TO kuro;

--
-- Name: signup_id_seq; Type: SEQUENCE; Schema: public; Owner: kuro
--

CREATE SEQUENCE public.signup_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.signup_id_seq OWNER TO kuro;

--
-- Name: signup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kuro
--

ALTER SEQUENCE public.signup_id_seq OWNED BY public.signup.id;


--
-- Name: signup id; Type: DEFAULT; Schema: public; Owner: kuro
--

ALTER TABLE ONLY public.signup ALTER COLUMN id SET DEFAULT nextval('public.signup_id_seq'::regclass);


--
-- Data for Name: signup; Type: TABLE DATA; Schema: public; Owner: kuro
--

COPY public.signup (id, name, email, password) FROM stdin;
\.


--
-- Name: signup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kuro
--

SELECT pg_catalog.setval('public.signup_id_seq', 1, false);


--
-- Name: signup signup_pkey; Type: CONSTRAINT; Schema: public; Owner: kuro
--

ALTER TABLE ONLY public.signup
    ADD CONSTRAINT signup_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

